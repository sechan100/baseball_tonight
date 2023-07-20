package com.baseballtonight.information;
import java.io.IOException;

import com.baseballtonight.information.controller.ParkInfoController;

public class App {
    private ParkInfoController parkInfoController;
    
    public void start(String mem_id) throws IOException, InterruptedException {
        parkInfoController = new ParkInfoController(mem_id);
    }

}
