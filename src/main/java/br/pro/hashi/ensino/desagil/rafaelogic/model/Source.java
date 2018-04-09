package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class Source implements Emitter {
    private boolean signal;

    public Source() {
        signal = false;
    }

    public void turn(boolean signal) {
        this.signal = signal;
    }

    public boolean read() {
        return signal;
    }
}