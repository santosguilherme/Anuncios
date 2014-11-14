package br.senai.sc.anuncios.app.activity.anuncio;

import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import br.senai.sc.anuncios.app.R;

@EActivity(R.layout.novo_anuncio)
public class NovoAnuncio extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.novo_anuncio, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}