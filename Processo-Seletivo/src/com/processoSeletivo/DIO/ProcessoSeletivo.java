package com.processoSeletivo.DIO;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatosAprovados = selecaoCandidatos();
        imprimirSelecionados(candidatosAprovados);
        ligarCandidato(candidatosAprovados);
    }

    static void ligarCandidato(String [] candidatosAprovados){
        int i = 0;
        boolean continuarTentando;
        boolean atendeu;

        for(String candidato: candidatosAprovados){
            if(candidato != null){
                int tentativasRealizadas = 1;
                continuarTentando = true;
                do{
                    atendeu = atender();
                    continuarTentando = !atendeu;
                    if(continuarTentando){
                        tentativasRealizadas++;
                    }else{
                        System.out.println("CONSEGUIMOS CONTATO COM " + candidatosAprovados[i] + " NA " + tentativasRealizadas + " TENTATIVA");
                    
                    }

                }while(continuarTentando && tentativasRealizadas < 3);

                if(!atendeu){
                    System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidatosAprovados[i] + " NO NUMERO MAXIMO DE " + tentativasRealizadas + " TENTATIVA");
                    i++;
                }
            }
        }
        System.out.printf("\n");

    }
    
    static void imprimirSelecionados(String[] candidatoAprovado){
        for(int i = 0; i < candidatoAprovado.length; i++){
            if(candidatoAprovado[i] != null){
                System.out.println("O candidato de n° " + (i + 1) + " " + candidatoAprovado[i] + " foi aprovado");
            }
        }
        System.out.printf("\n");
    }

    static String[] selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORLAN"};

        int i = 0;
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        String [] candidatoAprovado = new String[5];

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s solicitou este valor: %.2f \n", candidato, salarioPretendido);
            if(salarioBase >= salarioPretendido){
                candidatoAprovado[i] = candidato;
                candidatosSelecionados ++;
                i++;
            }
            candidatoAtual ++;
            
        }
        System.out.printf("\n");
        return candidatoAprovado;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
}
