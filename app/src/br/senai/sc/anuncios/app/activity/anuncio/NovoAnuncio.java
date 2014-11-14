package br.senai.sc.anuncios.app.activity.anuncio;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import br.senai.sc.anuncios.app.Anuncio;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.messages.ToastMessages;
import br.senai.sc.anuncios.app.service.rest.anuncio.AnuncioRestService;

@EActivity(R.layout.novo_anuncio)
public class NovoAnuncio extends Activity {

	@RestService
	AnuncioRestService anuncioRestService;

	@ViewById
	EditText tituloAnuncio;

	@ViewById
	EditText textoAnuncio;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.novo_anuncio, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.item_salvar_anuncio) {
			salvarAnuncio();
			return true;
		}
		if (id == R.id.item_voltar_menu) {
			finish();
			return true;
		}
		return false;
	}

	@Background
	public void salvarAnuncio() {
		Anuncio anuncio = new Anuncio();
		anuncio.titulo = this.tituloAnuncio.getText().toString();
		anuncio.texto = this.textoAnuncio.getText().toString();

		this.anuncioRestService.salvarAnuncio(getUsuarioLogado(), anuncio);
		exibirMensagemEVoltarParaMenu();
	}

	@UiThread
	public void exibirMensagemEVoltarParaMenu() {
		ToastMessages.exibirToast(getApplicationContext(), "Anúncio salvo com sucesso!");
		finish();
	}

	private Long getUsuarioLogado() {
		return 1L;
	}
}