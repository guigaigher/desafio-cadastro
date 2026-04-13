package exception;

public class NomeInvalidoException extends RuntimeException {
    public NomeInvalidoException(String messagem) {
        super(messagem);
    }
}
