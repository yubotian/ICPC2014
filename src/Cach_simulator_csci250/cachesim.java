package Cach_simulator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Yubo on 11/21/14.
 *
 * q1: maintain main memory?  using a hashmap<address , data></>
 * q2: hex- binary?
 *
 * write through: if store is a hit, write to cache and memory
 * write no allocate: if store is a miss, write only directly to memory
 *
 */

public class cachesim {
    public static void main(String[] args) {

        String file_name = args[0];
        int cache_size = Integer.parseInt(args[1]) * 1024;
        int associativity = Integer.parseInt(args[2]);
        int block_size = Integer.parseInt(args[3]);
//        System.out.printf("cache_size: %d \t associativity: %d \t block_size: %d \n", cache_size, associativity, block_size);

        List<String> operations = read(file_name);

        // initialize main memory
        HashMap<Integer, String> memory = new HashMap<Integer, String>();

        // calculate the and # of frames and # of sets we have
        int frame_total = cache_size/block_size;
        int set_total = frame_total/associativity;


        // initialize our cache.
        ArrayList<ArrayList<block>> cache = new ArrayList<ArrayList<block>>();

        for (int s = 0; s < set_total; s++){
            ArrayList<block> temp_set = new ArrayList<block>();
            for (int b = 0; b < associativity; b++){
                block temp_block = new block();
                temp_block.set_Invalid();    temp_block.init_Data(block_size);    temp_block.set_Usage(-1);

                temp_set.add(temp_block);
            }
            cache.add(temp_set);
        }

//        System.out.println("cache has # sets: " + cache.size());
//        System.out.println("each set has # frames:" + cache.get(0).size());


        // start processing operations and produce output
//        System.out.println("\n Start of the output file \n");

        int operation_count = 0; //this int tracks which operation we are on. this int is used to track the LRU block

        for (String s : operations){
//            System.out.println(s);
            String[] temp = s.split(" ");
            String type = temp[0];
            String hexNumber = temp[1].substring(2,8);
            int decimal_address = Integer.parseInt(hexNumber, 16);
//            System.out.println("Hex value is " + decimal_address);
            int access_size = Integer.parseInt(temp[2]);


            //int set = ( decimal_address - (decimal_address % block_size) ) % (block_size* set_total);
            int set_num = (decimal_address / block_size)  % (set_total);
            int tag = (decimal_address - (decimal_address % block_size));

//            System.out.println("decimal address is: " + decimal_address);
//            System.out.println("start of the block tag is: " + (decimal_address - (decimal_address % block_size) ));
//            System.out.println("should be in set: " + set_num);

            if (type.equals("store")){

                String value = temp[3];
                boolean hit = false;
                for (block b : cache.get(set_num)){
                    if (b.tag == tag && b.valid == 1){
                        b.set_Usage(operation_count);
                        //hit. write to cache and memory
                        hit = true;
                        int access_size_count = 0;
                        while (access_size_count < access_size ){
                            String temp_value = value.substring(access_size_count*2, access_size_count*2+2);
                            //update memory and cache
                            memory.put(decimal_address + access_size_count, temp_value);
                            b.set_Data(temp_value, (decimal_address - tag));;

                            access_size_count += 1;
                        }
                        b.set_Usage(operation_count); //update LRU
                        System.out.printf("store %s hit\n", temp[1]);
                    }

                }
                if (!hit) {
                    //miss. write only directly to memory
                    int access_size_count = 0;
                    while (access_size_count < access_size ){
                        String temp_value = value.substring(access_size_count*2, access_size_count*2+2);
                        //update memory
//                        System.out.println(temp_value);
                        memory.put(decimal_address + access_size_count, temp_value);
                        access_size_count += 1;
//                        System.out.println("WRITE ONCE TO MEMORY");
                    }

                    System.out.printf("store %s miss\n", temp[1]);

                }



            } else { //load
                boolean hit = false;
                for (block b : cache.get(set_num)) {
                    if (b.tag == tag) {
                        hit = true;
                        b.set_Usage(operation_count);

                        int access_size_count = 0;
                        StringBuilder t = new StringBuilder();
                        while (access_size_count < access_size ){
                            String buffer = b.get_Data((decimal_address - tag) + access_size_count );
                            t.append(buffer);

                            access_size_count += 1;
                        }

                        System.out.printf("load %s hit %s\n", temp[1] ,t.toString() );


                    }
                }
                if (!hit){
                    //miss. load from memory

                    //select the LRU block to evict( in terms of implementation, overwrite)
                    int LRU = cache.get(set_num).get(0).usage;
                    block LRU_block = cache.get(set_num).get(0);

//                    System.out.println("before check LRU block IS : " + LRU_block.tag);

                    for (block b : cache.get(set_num)){
                        if (b.usage <= LRU) {
//                            System.out.println("LRU is : " + LRU_block.tag);
                            LRU_block = b;
                        }
                    }

//                    System.out.println(LRU_block.tag);

                    //overwrite this LRU_block with the data loaded from memory
                    int load_count = 0;

                    while(load_count < block_size){
                        //System.out.println(decimal_address);
                        //System.out.println(decimal_address+load_count);

                        if (memory.containsKey( tag + load_count )){
                            LRU_block.set_Data(memory.get(tag+load_count),load_count);
                        } else {
                            //data hasnt been written before, so value in main should be zero
                            LRU_block.set_Data("00", load_count);


                        }
                        load_count++;

                    }

                    //now update the usage, tag, valid bit of THIS BLOCK
                    //and load the value from cache
                    LRU_block.set_Usage(operation_count);
                    LRU_block.set_Tag(tag);
                    LRU_block.set_Valid();

                    int access_size_count = 0;
                    StringBuilder t = new StringBuilder();
                    while (access_size_count < access_size ){
                        String buffer = LRU_block.get_Data((decimal_address - tag) + access_size_count );
                        t.append(buffer);

                        access_size_count += 1;
                    }

                    System.out.printf("load %s miss %s\n", temp[1] ,t.toString() );
                }
            }
            operation_count++;
        }

//        String hexNumber = "1a25bb";
//        int d = Integer.parseInt(hexNumber, 16);

//        System.out.println("test case " + memory.get(d));


//        System.out.println("\n Finished processing " + file_name);
    }

    static class block{
        int valid;
        int tag;
        String[] data;
        int usage; //usagecomes from the count on operations. smallest usage value -> least recently used block


        public void set_Valid(){
            this.valid = 1;
        }

        public void set_Invalid(){
            this.valid = 0;
        }

        public void set_Usage(int count){
            this.usage = count;
        }

        public void set_Tag(int tag){
            this.tag = tag;
        }

        public void init_Data(int block_size){
            String[] data = new String[block_size];
            this.data = data;

        }

        public void set_Data(String data, int i){
            this.data[i] = data;
        }

        public String get_Data(int i ){
            return this.data[i];
        }

    }

    // function to read in file. I use this block of code for all files read in for past programming contests.
    public static List<String> read(String filename){
        List<String> operations = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("/Users/Yubo/Documents/CompSci309/ICPC2014/src/Cach_simulator/tracefile2"));
            String line;
            while ((line = reader.readLine()) != null){
                operations.add(line);
            }
            reader.close();
            return operations;
        } catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }
}

    



