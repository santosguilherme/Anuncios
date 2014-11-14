package br.senai.sc.anuncios.app.activity.home;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;
import org.androidannotations.annotations.rest.RestService;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.ListView;
import br.senai.sc.anuncios.app.Anuncio;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.activity.menu.Menu_;
import br.senai.sc.anuncios.app.service.rest.anuncio.AnuncioRestService;

@WindowFeature({ Window.FEATURE_NO_TITLE})
@EActivity(R.layout.home)
public class Home extends Activity {

	@RestService
	AnuncioRestService anuncioRestService;

	@ViewById
	ListView listAnuncios;

	private ListAdapter adapter;

	@AfterViews
	void iniciarListAdapter() {
		searchAsync(getUsuarioLogado());
	}

	private long getUsuarioLogado() {
		return 1L;
	}

	@Click(R.id.botao_menu)
	public void irParaOMenu() {
		Intent intent = Menu_.intent(this).get();
		startActivity(intent);
	}

	@Background
	void searchAsync(Long userId) {
		List<Anuncio> anunciosUsuario = this.anuncioRestService.listarAnunciosUsuario(userId);
		atualizarListaAnuncios(anunciosUsuario);
	}

	@UiThread
	public void atualizarListaAnuncios(List<Anuncio> anuncios) {
		this.adapter = new AnuncioListAdapter(anuncios, this);
		this.listAnuncios.setAdapter(adapter);
	}
}