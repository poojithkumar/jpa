package com.jpa.jpatest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


@SpringBootApplication
@EnableScheduling
public class TestController {
    private int x=0;

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    void publish() throws IOException, MessagingException, javax.mail.MessagingException, GitAPIException, InterruptedException {
        String repoUrl = "https://github.com/lochankc/DIS.git";
        String cmd = "git clone https://github.com/poojithkumar/bin.git";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while ((line=buf.readLine())!=null) {
            System.out.println(line);
        }


//        String[] cmd = { "git", "clone","https://github.com/lochankc/DIS.git" };
//        Process p = Runtime.getRuntime().exec(cmd);
//        System.out.println(p);
//


//        InetSocketAddress socket =
//                InetSocketAddress.createUnresolved("web-proxy.in.softwaregrp.net", 8080);
////        System.out.println(new Proxy(Proxy.Type.HTTP, socket).address().toString());
//        Git git = Git.cloneRepository()
//                .setURI("https://github.com/poojithkumar/bin.git")
//                .setDirectory(new File("C:\\Users\\Phegde\\Desktop\\assets\\hello-world"))
//                .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "poojithkumar", "598280@@pooju" ) )
//                .call();
//        StoredConfig gitConfig = git.getRepository().getConfig();
//        gitConfig.setString("remote", "origin", "proxy",new Proxy(Proxy.Type.HTTP, socket).address().toString());
//        gitConfig.save();
//        System.out.println(new Proxy(Proxy.Type.HTTP, socket).address().toString());
//

        System.out.println("hahahahaha");
        RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject("http://localhost:8080/cdfBase", String.class);
      //  String quote = restTemplate.getForObject("http://16.103.35.252:5001/api/v1.0/job/101", String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(quote);
        int numberOfBaseImage= Integer.parseInt((actualObj.get("page").get("totalElements")).toString());
        System.out.println(actualObj.get("_embedded").get("cdfBase").get(numberOfBaseImage-1));
        System.out.println(numberOfBaseImage+""+x);
        actualObj=actualObj.get("_embedded").get("cdfBase").get(numberOfBaseImage-1);
        String body=actualObj.toString();
        if(numberOfBaseImage-x==1){

            restTemplate.postForEntity("http://localhost:8080/api/mail",body,String.class);


        }else
            if(x==0&& numberOfBaseImage!=0){
                String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Phegde\\Desktop\\jpatest\\src\\main\\resources\\templates\\template-1.html")));
String s="mu";
                //restTemplate.postForEntity("http://localhost:8080/api/mail/send","template-1",String.class);

                ModelAndView model = new ModelAndView("template-1");
               // model.addAttribute("variableName", s);
                 model.addObject("variableName", s);
                System.out.println("starting application\n"+model);
            }

        x=numberOfBaseImage;
      //  System.out.println(actualObj.get("page").get("totalElements"));

    }


}
