package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

class SampleClient
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine() + "\r\n";

        try
        {
            Socket s = new Socket("whois.ripe.net", 43);
            BufferedReader dIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

            s.getOutputStream().write(ip.getBytes());

            String result = dIn.readLine();
            while (result != null) {
                System.out.print(result + "\n");
                result = dIn.readLine();
            }
        }
        catch(Exception e) {
            System.out.println("init error: "+e);
        }
    }
}