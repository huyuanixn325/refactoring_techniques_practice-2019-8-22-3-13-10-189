package com.tws.refactoring.extract_method;

import com.tws.refactoring.extract_variable.BannerRender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        System.out.print("hello");
        assertEquals("hello", outContent.toString());
    }

    @Test
    public void should_return_IE_when_input_MAC_IE(){

        //given
        BannerRender bannerRender = new BannerRender();
        //when
        String result = bannerRender.renderBanner("MAC","IE");
        //then
        assertEquals("IE on Mac?",result);
    }
    @Test
    public void should_return_banner_when_input_fiex(){
        //given
        BannerRender bannerRender = new BannerRender();
        //when
        String result = bannerRender.renderBanner("HP","Fiex");
        //then
        assertEquals("banner",result);
    }



}