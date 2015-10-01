/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author Marthin
 */
public class NoSuchCardException extends RuntimeException {
    int pos;
    String msg;
    public NoSuchCardException(String msg, int pos) {
        this.msg = msg;
        this.pos = pos;
    }
    public NoSuchCardException(String msg) {
        super(msg);
    }
    public NoSuchCardException() {
        super();
    }
    @Override
    public String getMessage(){
        msg += pos;
        return msg;
    }
}
