package it.unisa.ackc.validator;

public class ValidatorLogic {
    public static Validator CAMPO_NON_VUOTO(String nome, String valore) {
        return new ValidatorCampo<String>(nome, valore) {
            @Override
            public void valida() throws RuntimeException {
                if (getValore() == null || getValore().length() == 0) {
                    throw new IllegalArgumentException("Il campo " + getNome() + " non può essere vuoto");
                }
            }
        };
    }

    public static Validator CAMPO_ENTE_CERTIFICATORE(String nome, String valore) {
        return new ValidatorCampo<String>(nome, valore) {
            @Override
            public void valida() throws RuntimeException {
                if (getValore().length() > 64) {
                    throw new IllegalArgumentException("Il campo ente certificatore non può superare i 64 caratteri");
                }
            }
        };
    }
}
