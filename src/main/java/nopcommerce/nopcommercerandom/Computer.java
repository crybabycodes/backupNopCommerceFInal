package nopcommerce.nopcommercerandom;

import nopcommerce.nopcommerceenums.computeroptions.CPU;
import nopcommerce.nopcommerceenums.computeroptions.Ram;

import java.util.Random;
public class Computer {

    public static final Random random = new Random();

    public static String randomCPU() {
        CPU[] cpus = CPU.values();
        int randomIndex = random.nextInt(cpus.length);
        return cpus[randomIndex].getProcessorOption();
    }

    public static String randomRam() {
        Ram[] rams = Ram.values();
        int randomIndex = random.nextInt(rams.length);
        return rams[randomIndex].getRamOption();
    }
}
