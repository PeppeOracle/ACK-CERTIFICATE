package it.unisa.ackc.proposta;

public interface Checker<T> {
    check(T dato, Notification notification);
}
