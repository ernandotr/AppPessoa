package br.com.ernando.apppessoa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listViewOpcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.criarComponentes();

        this.criarEventos();

        this.carregaOpcoesLista();
    }

    private void carregaOpcoesLista() {
        String[] itens = new String[2];

        itens[0] = "Cadastrar";
        itens[1] = "Consultar";

        ArrayAdapter<String> arrayItens = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, itens);

        listViewOpcoes.setAdapter(arrayItens);
    }

    private void criarComponentes() {
        listViewOpcoes = (ListView) this.findViewById(R.id.listViewOpcoes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //CRIA EVENTO PARA A LISTA
    protected void criarEventos(){

        listViewOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcaoMenu = ((TextView) view).getText().toString();

                redirecionaTela(opcaoMenu);


            }
        });
    }

    //REDIRECIONA PARA A TELA SELECIONADA NO MENU
    protected void redirecionaTela(String opcaoMenu){

        Intent intentRedirecionar;

        if(opcaoMenu.equals("Cadastrar")){

            intentRedirecionar = new Intent(this, CadastrarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        }
        else if(opcaoMenu.equals("Consultar")){

            intentRedirecionar = new Intent(this, ConsultarActivity.class);
            startActivity(intentRedirecionar);
            finish();
        }
        else
            Toast.makeText(getApplicationContext(), "Opção inválida!", Toast.LENGTH_SHORT).show();

    }
}
