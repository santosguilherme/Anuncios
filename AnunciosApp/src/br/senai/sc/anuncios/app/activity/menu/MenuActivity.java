package br.senai.sc.anuncios.app.activity.menu;

import java.util.Arrays;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.activity.anuncio.NovoAnuncioActivity_;
import br.senai.sc.anuncios.app.activity.home.HomeActivity_;
import br.senai.sc.anuncios.app.activity.login.LoginActivity_;

@WindowFeature({ Window.FEATURE_NO_TITLE })
@EActivity(R.layout.menu)
public class MenuActivity extends Activity {

	private final String MENU_HOME = "Home";
	private final String MENU_MEUS_ANUNCIOS = "Meus anúncios";
	private final String MENU_NOVO_ANUNCIO = "Novo anúncio";
	private final String MENU_SAIR = "Sair";

	private final List<String> opcoesMenu = Arrays.asList(MENU_HOME,
			MENU_MEUS_ANUNCIOS, MENU_NOVO_ANUNCIO, MENU_SAIR);

	private ListAdapter adapter;

	@ViewById
	ListView listOpcoesMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@AfterViews
	public void registrarListenerItem() {
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, opcoesMenu);
		listOpcoesMenu.setAdapter(adapter);

		listOpcoesMenu
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView<?> parentAdapter,
							View view, int position, long id) {
						onItemOpceosClick(view);
					}
				});
	}

	private void onItemOpceosClick(View view) {
		TextView clickedView = (TextView) view;
		String textoSelecionado = clickedView.getText().toString();

		Intent intent = null;
		switch (textoSelecionado) {
		case MENU_HOME: {
			intent = HomeActivity_.intent(this).get();
			break;
		}
		case MENU_MEUS_ANUNCIOS: {
			intent = HomeActivity_.intent(this).get();
			break;
		}
		case MENU_NOVO_ANUNCIO: {
			intent = NovoAnuncioActivity_.intent(this).get();
			break;
		}
		case MENU_SAIR: {
			intent = LoginActivity_.intent(this).get();
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_CLEAR_TASK);
			intent.putExtra("EXIT", true);
			break;
		}
		}
		startActivity(intent);
	}
}