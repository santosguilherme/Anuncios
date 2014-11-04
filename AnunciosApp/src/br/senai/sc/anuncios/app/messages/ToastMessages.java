package br.senai.sc.anuncios.app.messages;

import android.content.Context;
import android.widget.Toast;

public class ToastMessages {
	
	public static void exibirToast(Context context,final String mensagem){
		Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
	}
	
}
