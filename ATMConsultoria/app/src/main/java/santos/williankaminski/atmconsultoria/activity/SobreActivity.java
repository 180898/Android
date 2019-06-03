package santos.williankaminski.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import santos.williankaminski.atmconsultoria.R;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String descricao = "A ATM Consultoria tem como missão apoiar as organizações que desejam alcançar o sucesso" +
                "através da excelência em gestão e da busca pela qualdade. \n\n" + "Nosso trabalho é dar suporte às empresas que desejam" +
                "se certificar em padrões de qualidade ao investir no desenvolvimento e evolução de sua gestão, por meio da otimizaçõa" +
                "dos processos e da disseminação dos Fundamentos e Crotérios de Excelência.";

        View sobre = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale conosco")
                .addEmail("developer.williansantos@gmail.com","Envie um e-mail")
                .addWebsite("https://github.com/willian-kaminski", "Acesse nosso site")
                .addGroup("Acesse nossas redes sociais")
                .addFacebook("google")
                .addTwitter("google")
                .addYoutube("google")
                .addPlayStore("com.google.android.apps.plus")
                .addGitHub("willian-kaminski")
                .addInstagram("_oh_will_")
                .create();

        setContentView(sobre);
    }
}
