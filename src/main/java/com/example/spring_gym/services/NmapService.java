package com.example.spring_gym.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class NmapService {

    public String ejecutarNmap(String ip) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder(
                "nmap", "-sV", "--script", "vuln", "-oX", "scan.xml", ip
        );
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            return "Error ejecutando Nmap. Código: " + exitCode;
        }
        return output.toString();
    }


}
