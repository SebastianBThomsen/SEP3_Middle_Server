package com.group5.sep3.DataBaseCommunication;


import com.group5.sep3.BusinessLogic.model.Spike;
import org.springframework.web.client.RestTemplate;


public class RestClientImpl implements RestClient {

    private String ROOT = "http://localhost:5000/";

    private RestTemplate rest = new RestTemplate();

    @Override
    public void postSpike(Spike spike) {
        System.out.println("We are about to post spike to REST SERVER MY DUDE" + spike.toString());
    }

    @Override
    public Spike getSpike(String spikeName) {
        String result = rest.getForObject(ROOT +"spike/" + spikeName, String.class);
        Spike spike = Spike.FromJson(result);
        return spike;
    }

}
