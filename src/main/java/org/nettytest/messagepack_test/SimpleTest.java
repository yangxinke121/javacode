package org.nettytest.messagepack_test;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();

        list.add("msgpack");
        list.add("kumofs");
        list.add("viver");

        MessagePack messagePack = new MessagePack();
        // 序列化
        byte[] write = messagePack.write(list);

        // 反序列化
        List<String> read = messagePack.read(write, Templates.tList(Templates.TString));
        System.out.println(read.get(0));
        System.out.println(read.get(1));
        System.out.println(read.get(2));
    }
}
