package br.senai.sc.anuncios.app.activity.login;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import br.senai.sc.anuncios.app.R;
import br.senai.sc.anuncios.app.activity.home.Home_;
import br.senai.sc.anuncios.app.messages.ToastMessages;

@WindowFeature({ Window.FEATURE_NO_TITLE})
@EActivity(R.layout.login)
public class Login extends Activity {
	
	@ViewById(R.id.usuario_login)
	EditText usuarioEditText;
	
	@ViewById(R.id.senha_login)
	EditText senhaEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@AfterViews
	public void verificarSeEhParaFinalizarApp() {
		if (getIntent().getBooleanExtra("EXIT", false)) {
		    finish();
		}
	}
	
	@Click(R.id.botao_login_entrar)
	public void autenticarUsuario(){
		ToastMessages.exibirToast(this, "Loading...");
		startActivity(Home_.intent(this).get());
	}
	
	public void cadastrarNovoUsuario(View view){
		ToastMessages.exibirToast(this, "Função não implementada");
	}
	
	public void recuperarSenhaUsuario(View view){
		ToastMessages.exibirToast(this, "Função não implementada");
	}
	
}
