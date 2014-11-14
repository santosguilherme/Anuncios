package br.senai.sc.anuncios.app.activity.menu;

import java.util.Arrays;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.activity.anuncio.NovoAnuncio_;
import br.senai.sc.anuncios.app.activity.home.Home_;
import br.senai.sc.anuncios.app.activity.login.Login_;

@WindowFeature({ Window.FEATURE_NO_TITLE })
@EActivity(R.layout.menu)
public class Menu extends Activity {

	private final String MENU_HOME = "Home";
	private final String MENU_NOVO_ANUNCIO = "Novo anúncio";
	private final String MENU_SAIR = "Sair";

	private final List<String> opcoesMenu = Arrays.asList(MENU_HOME, MENU_NOVO_ANUNCIO, MENU_SAIR);

	private ListAdapter adapter;

	@ViewById
	ListView listOpcoesMenu;

	@AfterViews
	public void registrarListenerItem() {
		this.adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, this.opcoesMenu);
		this.listOpcoesMenu.setAdapter(this.adapter);

		this.listOpcoesMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
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
				intent = Home_.intent(this).get();
				break;
			}
			case MENU_NOVO_ANUNCIO: {
				intent = NovoAnuncio_.intent(this).get();
				break;
			}
			case MENU_SAIR: {
				intent = Login_.intent(this).get();
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				intent.putExtra("EXIT", true);
				break;
			}
		}
		startActivity(intent);
	}
}