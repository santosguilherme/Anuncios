package br.senai.sc.anuncios.app.activity.home;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.senai.sc.anuncios.app.Anuncio;
import br.senai.sc.anuncios.app.R;

public class AnuncioListAdapter extends BaseAdapter{
	
	private List<Anuncio> lista;
	private Context context;
	
	public AnuncioListAdapter(List<Anuncio> lista, Context context) {
		this.lista = lista;
		this.context = context;
	}

	@SuppressLint("ViewHolder") 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Anuncio anuncio = getItem(position);

		LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View listView = inflater.inflate(R.layout.anuncios_list, parent, false);
		
		TextView titulo = (TextView) listView.findViewById(R.id.titulo);
		titulo.setText(anuncio.titulo);
		
		TextView texto = (TextView) listView.findViewById(R.id.texto);
		texto.setText(anuncio.texto);
		
		TextView dataCadastro = (TextView) listView.findViewById(R.id.cadastradoEm);
		String dataCadastroString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(anuncio.dataCadastroMillis));
		dataCadastro.setText(dataCadastroString);
		
		return listView;
	}

	@Override
	public int getCount() {
		return this.lista.size();
	}

	@Override
	public Anuncio getItem(int index) {
		return this.lista.get(index);
	}

	@Override
	public long getItemId(int index) {
		return getItem(index).indice;
	}
}
