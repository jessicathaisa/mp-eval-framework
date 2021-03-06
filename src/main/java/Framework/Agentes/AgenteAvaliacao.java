/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Agentes;

import Framework.Modelo.Avaliavel;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import java.util.List;

/**
 *
 * @author Jessica
 */
public abstract class AgenteAvaliacao<T extends Avaliavel> extends Agent {

    public abstract List<T> verificaNovasAvaliacoes();
    
    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this){

            @Override
            public void action() {
                List<T> lista = verificaNovasAvaliacoes();
                if(lista != null && !lista.isEmpty()){
                    for(T obj : lista){
                        obj.avaliar();
                    }
                }
            }
            
        });
    }
    
}
