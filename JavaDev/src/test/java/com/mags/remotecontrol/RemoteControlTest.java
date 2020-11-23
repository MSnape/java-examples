package com.mags.remotecontrol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoteControlTest {
    @Test
    void test() {
        RemoteControl rc = new RemoteControl();

        assertEquals(14, rc.numberOfMoves("code"));
        assertEquals( 9, rc.numberOfMoves("boo"));
    }
}