/*---------------------------------------
       Christopher García 20541
        3er semestre - Ciclo 1
    Algoritmos y estructura de datos
---------------------------------------*/ 
//Importes 
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JUnit {
    
    CalculadoraF Calcu = new CalculadoraF();
    StackVector<Integer> Stack = new StackVector<Integer>();

//Evidencia de las pruebas unitarias, están comentadas ya que al ejecutarse en consola el programa ya no se 
//ejecuta porque no reconoce JUnit, pero si se descomentan funcionan perfectamente :D

/*------------------------------------------------------------------------------------------------------*/	
	//Prueba unitaria#1
    //Se comprueba que la calculadora opera correctamente
	@Test
    public void ComprobantePostFix(){

        System.out.println();
        System.out.println("Operacion: 6 2 3 + *");
        System.out.println("Resultado de la operacion: " + Calcu.Calculo("6 2 3 + *"));

    /*Debido a que se estableció que el método cálculo devolvería un String
      se evalua con Strings, la operación que se planteaba en la hoja de
      trabajo se utilizó para este ejemplo y como resultado devuelve 30
      si en dado caso se pone otra cosa distinta de 30 muestra error y eso 
      significa que funciona correctamente porque opera bien*/
        assertEquals(Calcu.Calculo("6 2 3 + *"), "30");

        System.out.println("Si lees este mensaje, la prueba unitaria resultó un éxito");
    }   

	//Prueba unitaria#2
    /*Se comprueba que los datos se manejen bien mediante operaciones de Vector (Push, pop, etc.)
      Se realiza una serie de Push y pop y se evalua que el tamaño del Stack sea el adecuado de acuerdo
      a la operación realizada*/
	@Test
    public void GuardadoDatos(){

    //Si en dado caso el tamaño del Stack no coincide con lo esperado la prueba falla
    //De lo contrario resulta efectiva para probar el manejo de información

        System.out.println("\nTamaño del Stack actual: "+Stack.size());
        System.out.println("Agregamos 1");
        Stack.push(1);
        assertEquals(Stack.size(), 1);
        System.out.println("Tamaño del Stack actual: "+Stack.size());
        System.out.println("Agregamos 2");
        Stack.push(2);
        assertEquals(Stack.size(), 2);
        System.out.println("Tamaño del Stack actual: "+Stack.size());
        System.out.println("Agregamos 18");
        Stack.push(18);
        assertEquals(Stack.size(), 3);
        System.out.println("Tamaño del Stack actual: "+Stack.size());
        System.out.println("Quitamos 18");
        Stack.pop();
        assertEquals(Stack.size(), 2);
        System.out.println("Tamaño del Stack actual: "+Stack.size());
        System.out.println("Agregamos 10");
        Stack.push(10);
        assertEquals(Stack.size(), 3);
        System.out.println("Tamaño del Stack actual: "+Stack.size());

    } 
	//Prueba unitaria#3
    /*Se utilizará este test para comprobar que si en dado caso
      los operadondos son insuficientes para realizar una operación
      postfix se muestre una advertencia*/

    @Test
    public void InsuficientesOperandos(){

        //Se ingresa una operación con operandos insuficientes y se escribe el valor esperado
        //En este caso es un mensaje como advertencia
        System.out.println("\nOperación: 1 +");
        System.out.println("Resultado: Falta de operandos");
        assertEquals(Calcu.Calculo("1 +"), "Lo sentimos, no es posible operar esta expresion");
        System.out.println("Si lees esto el resultado es el correcto, no hay suficientes operandos\n");

        //Si ingresamos una operación con los operandos necesarios y colocamos la advertencia
        //Esta prueba fallará pues si puede operar
        System.out.println("Operación: 1 2 +");
        System.out.println("Resultado: 3");
        assertEquals(Calcu.Calculo("1 2 +"), "3");
        System.out.println("Si lees esto el resultado es el correcto, se puede operar");
    } 
/*-------------------------------------------------------------------------------------------------------*/
}
