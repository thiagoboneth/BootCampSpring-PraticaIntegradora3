package bootcamp.praticaintegradora3.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
public class PessoaController {
    Calendar calendario = Calendar.getInstance();

    @GetMapping("/{dia}/{mes}/{ano}")
    public String data(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        int diaAtual = calendario.get(Calendar.DAY_OF_MONTH);
        int mesAtual = (calendario.get(Calendar.MONTH) + 1);
        int anoAtual = calendario.get(Calendar.YEAR);
        int idade;

        if (mes < mesAtual) {
            idade = anoAtual - ano;
        }
        else if (mes == mesAtual) {
            if (dia <= diaAtual) {
                idade = anoAtual - ano ;
            }else {
                idade = anoAtual-ano-1;
            }
        } else {
            idade = anoAtual - ano - 1;
        }
        return "Sua idade é " + idade;
    }
}
