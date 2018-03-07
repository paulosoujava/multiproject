package receita.com.br.javajokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ALL")
public class Joker {

    Random r = new Random();
    List<String> jokes;

    public String getJoker() {
        initJoker();
        return jokes.get(r.nextInt(jokes.size()));
    }

    public String getFreeJoker() {
        initFreeJoker();
        return jokes.get(r.nextInt(jokes.size()));
    }

    private void initJoker() {
        jokes = new ArrayList<>();
        jokes.add("1-Batman pegou seu bat-sapato social e seu bat-blazer,aonde ele foi?A um Bat-zado");
        jokes.add("2-Dois litros de leite atravessaram a rua e foram atropelados.. Um morreu, o outro não, por quê? Por que um deles era Longa Vida");
        jokes.add("3-Porque o elefante nao pega fogo? Porque ele já é cinza");
        jokes.add("4-O que dá o cruzamento de pão, queijo e um macaco? X-panzé");
        jokes.add("5-O que o cavalo foi fazer no orelhão?Passar um trote");
        jokes.add("6-Porque a Angélica não mata baratas? Porque ela espera o Maurício Mattar");
        jokes.add("7-O que o tomate foi fazer no banco?Foi tirar extrato.");
        jokes.add("8-O que a galinha foi fazer na igreja ?Assistir a Missa do Galo.");
        jokes.add("9-Por que a mata é virgem?Porque o vento é fresco.");
        jokes.add("10-or que a Coca-Cola e a Fanta se dão muito bem?Porque se a Fanta quebra, a Coca-Cola !");
        jokes.add("11-Por que não é bom guardar o quibe no freezer?Porque lá dentro ele esfirra.");
        jokes.add("12-Por que as plantinhas não falam?Porque elas são mudas.");
        jokes.add("13-O que o advogado do frango foi fazer na delegacia ?Foi soltar a franga.");
        jokes.add("14-Como se faz omelete de chocolate ?Com ovos de páscoa !");
        jokes.add("15-Por que na Argentina as Vacas vivem olhando pro céu?Porque tem Boi nos Ares!");
        jokes.add("16-Para que serve óculos verde ?Para verde perto...");
        jokes.add("17-Para que serve óculos vermelho ?Para vermelhor...");
        jokes.add("18-Para que serve óculos marrom ?Para ver marromenos...");
        jokes.add("19-Por que a mulher do Hulk divorciou-se dele ?Porque ela queria um homem mais maduro...");
        jokes.add("20-Por que o jacaré tirou o jacarezinho da escola?Porque ele réptil de ano.");
    }


    private void initFreeJoker() {
        jokes = new ArrayList<>();
        jokes.add("1-Batman pegou seu bat-sapato social e seu bat-blazer,aonde ele foi?A um Bat-zado");
        jokes.add("2-Dois litros de leite atravessaram a rua e foram atropelados.. Um morreu, o outro não, por quê? Por que um deles era Longa Vida");
        jokes.add("3-Porque o elefante nao pega fogo? Porque ele já é cinza");
        jokes.add("4-O que dá o cruzamento de pão, queijo e um macaco? X-panzé");
        jokes.add("5-O que o cavalo foi fazer no orelhão?Passar um trote");
    }
}
