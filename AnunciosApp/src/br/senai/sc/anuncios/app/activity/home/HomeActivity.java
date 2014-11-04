package br.senai.sc.anuncios.app.activity.home;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import br.senai.sc.anuncios.app.Anuncio;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.activity.menu.MenuActivity_;

@WindowFeature({ Window.FEATURE_NO_TITLE})
@EActivity(R.layout.home)
public class HomeActivity extends Activity {

	@ViewById
	ListView listAnuncios;

	private ListAdapter adapter;

	@AfterViews
	void iniciarListAdapter() {
		List<Anuncio> anuncios = new ArrayList<>();

		Anuncio a = new Anuncio();
		a.id = 1;
		a.titulo = "titulo";
		a.texto = "texto";
		anuncios.add(a);

		Anuncio b = new Anuncio();
		b.id = 2;
		b.titulo = "titulo2";
		b.texto = "texto3";
		
		anuncios.add(b);
		this.adapter = new AnuncioListAdapter(anuncios, this);
		this.listAnuncios.setAdapter(adapter);
	}

	@Click(R.id.botao_menu)
	public void irParaOMenu() {
		Intent intent = MenuActivity_.intent(this).get();
		startActivity(intent);
	}
}
