package edu.javaApi.sem6;

import java.util.Objects;
import java.util.Random;

public class Notebook {
    private static int idCount = 1;
    private int id;
    private String mem;
    private String hdd;
    private String vMem;
    private String proc;
    private String vCard;
    private String os;
    private String color;

    public Notebook(String mem, String hdd, String vMem, String proc, String vCard, String os, String color) {
        this.mem = mem;
        this.hdd = hdd;
        this.vMem = vMem;
        this.proc = proc;
        this.vCard = vCard;
        this.os = os;
        this.color = color;
        this.id = idCount;
        idCount++;
    }

    public Notebook() {
        String[] procArr = { "Intel", "AMD" };
        String[] vCardArr = { "NVidia", "Ati" };
        String[] osArr = { "Windows", "Linux" };
        String[] colorArr = { "Black", "Grey", "White" };
        Random rnd = new Random();
        this.mem = ((rnd.nextInt(16) + 1) * 2) + "";
        this.hdd = ((rnd.nextInt(6) + 1) * 500) + "";
        this.vMem = ((rnd.nextInt(6) + 1) * 512) + "";
        this.proc = procArr[rnd.nextInt(procArr.length)];
        this.vCard = vCardArr[rnd.nextInt(vCardArr.length)];
        this.os = osArr[rnd.nextInt(osArr.length)];
        this.color = colorArr[rnd.nextInt(colorArr.length)];
        this.id = idCount;
        idCount++;
    }

    public String getParam(String param) {
        switch (param) {
            case "mem":
                return this.mem;
            case "hdd":
                return this.hdd;
            case "proc":
                return this.proc;
            case "vMem":
                return this.vMem;
            case "vCard":
                return this.vCard;
            case "os":
                return this.os;
            case "color":
                return this.color;
            default:
                return "";
        }

    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Proc is: %s, Ram is: %s Gb, VideoCard is: %s, VideoRam is: %s Mb, HDD: %s Gb, OS: %s, Color is: %s.",
                id, proc, mem, vCard, vMem, hdd, os, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (this.getClass() != obj.getClass())
            return false;
        Notebook nb = (Notebook) obj;
        return this.mem == nb.mem && this.hdd == nb.hdd && this.vMem == nb.vMem && this.proc == nb.proc
                && this.vCard == nb.vCard && this.os == nb.os && this.color == nb.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mem, hdd, vMem, proc, vCard, os, color);
    }
}
