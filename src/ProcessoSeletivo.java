import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        System.out.println("Processo Seletivo");
        analisarCandidato();
        selecaoCandidatos();
        imprimindoCandidatos();

        String[] candidatosSelecionados = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : candidatosSelecionados) {
            entrarContato(candidato);
        }

    }

    static void entrarContato(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");


    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimindoCandidatos() {
        String[] candidatosSelecionados = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo com a ordem de seleção pelo índice");
        for (int x = 0; x < candidatosSelecionados.length; x++) {
            System.out.println((x + 1) + "° Candidato é " + candidatosSelecionados[x]);
        }

        System.out.println("Imprimindo todos sem a necessidade de exibir o índice");

        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }

    }

    static void selecaoCandidatos() {
        double salarioBase = 2000.0;
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};
        int totalSelecionados = 0;
        int proximoCandidato = 0;
        while (totalSelecionados < 5 && proximoCandidato < candidatos.length) {
            String candidato = candidatos[proximoCandidato++];
            double valorPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " está pedindo " + valorPretendido);
            if (valorPretendido > salarioBase) {
                System.out.println("QUE PENA!! O candidato " + candidato + " NÃO foi selecionado ");

            } else {
                System.out.println("LEGAL!! O candidato " + candidato + " foi selecionado ");
                totalSelecionados++;
            }

        }
        System.out.println("Total de selecionados: " + totalSelecionados);
        System.out.println("Total de consultados: " + proximoCandidato);

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato. ");

        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta.");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }
}
