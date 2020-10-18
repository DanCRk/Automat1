package com.Automat.proyect_dinero.fragments.TabsMateriales;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.Automat.proyect_dinero.Entidades.EquipoMateriales;
import com.Automat.proyect_dinero.R;
import com.Automat.proyect_dinero.adaptadores.AdapterEquipoMateriales;

import java.util.ArrayList;


public class Tab4Materiales extends Fragment {

    EditText buscador;
    AdapterEquipoMateriales adapterEquipoMateriales;
    RecyclerView recyclerView;
    ArrayList<EquipoMateriales> listaMateriales;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4_materiales, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewMaterialestab4);
        buscador = view.findViewById(R.id.bucadortab4_materiales);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) { filtrar(s.toString());
            }
        });

        listaMateriales = new ArrayList<>();

        guardarLista();
        mostrarLista();
        return (view);
    }

    public void guardarLista(){

        listaMateriales.add(new EquipoMateriales("Aceros de Maquinarias","Los Aceros grado maquinaria generalmente son aceros muy versátiles de baja aleación utilizados para " +
                "la construcción o reparación de maquinaria en general. Existen varios grupos o sub-familias dentro de los aceros Maquinaria, designados así, en función a los elementos aleantes de mayor presencia " +
                "en su composición química.",R.drawable.sis));

        listaMateriales.add(new EquipoMateriales("Acero (AISI) 3115","Es un acero para maquinaria, utilizado para aplicaciones donde requieran dureza y resistencia superficial entre " +
                "otras, además aplicables en componentes de transmisión de la industria automovilística.",0));

        listaMateriales.add(new EquipoMateriales("Acero 16NC6","Se aplica en elementos de Maquinarias que requieran alta resistencia al desgaste y buena tenacidad en el núcleo. " +
                "Alta resistencia al desgaste superficial y buena tenacidad en el núcleo después de la Cementación y Bonificado.",0));

        listaMateriales.add(new EquipoMateriales("Acero 1040","Se utiliza para máquinas, tornillos de arado y de carros, alambre de amarre, pernos U, barras de refuerzo de hormigón, " +
                "piezas forjadas y manantiales que no son críticos.",0));

        listaMateriales.add(new EquipoMateriales("Acero 1060 (Acero al carbon)","Se utiliza donde haya mucho desgaste. Este acero templado puede alcanzar una alta resistencia a la " +
                "tensión y resistencia al desgaste. Aplicaciones: Implementos agrícolas, porta herramientas, discos de embrague, ejes, flechas, cinceles.",0));

        listaMateriales.add(new EquipoMateriales("Acero (AISI) 5115","Se utiliza en la elaboración de máquinas en general, también puede ser utilizados para la producción de moldes " +
                "para plástico, resina sintética, placas de base, barras de plegado, columnas guía, piezas de engranaje, piezas de articulación, ejes, engranajes, bielas, pernos del émbolo, árbol de levas," +
                " bulones, espigas.",0));

        listaMateriales.add(new EquipoMateriales("Acero 12L14","Acero de bajo carbono resulfurado y refosforado con aleación de plomo, de extraordinarias características de " +
                "maquinabilidad " +
                "y terminación superficial. Apto para realizar recubrimientos electrolíticos tales como zincado, cromado y niquelado.",0));

        listaMateriales.add(new EquipoMateriales("Acero TM (Acero corrugado)","Es una clase de acero laminado diseñado especialmente para construir elementos estructurales" +
                " de hormigón armado. " +
                "Es una aleación del acero con 0.22% Carbono, 0.05% Fósforo, 0.05% Azufre y 0.012% de Nitrógeno Se trata de barras de acero que presentan resaltos o corrugas que mejoran la adherencia con el " +
                "hormigón, y poseen una " +
                "gran ductilidad, la cual permite que las barras se puedan cortar y doblar con mayor facilidad.",0));

        listaMateriales.add(new EquipoMateriales("Acero 8620 (Acero para cementacion)","La excelente combinación de sus elementos de aleación le imparten gran tenacidad " +
                "en el núcleo, alta dureza" +
                " superficial y resistencia al desgaste. Tienen buena maquinabilidad por lo que es ideal para muchas aplicaciones, en especial en piezas pequeñas y medianas.",0));

        listaMateriales.add(new EquipoMateriales("Acero (AISI) 4130","Se utiliza principalmente en la construcción de aviones comerciales y militares y sistemas de apoyo " +
                "en tierra. El acero " +
                "aleado 4130 es un material de resistencia intermedia.",0));

        listaMateriales.add(new EquipoMateriales("Acero 4140 (Acero de baja aleación al Cromo Molibdeno)","Se suministra con o sin tratamiento de bonificado (temple y revenido). Se" +
                " utiliza en " +
                "forma general en la fabricación de piezas de medianas dimensiones que requieren alta resistencia mecánica y tenacidad. Buena resistencia a la torsión y fatiga.",0));

        listaMateriales.add(new EquipoMateriales("Acero 4340 (Aleación de Níquel-Cromo-Molibdeno)","Dicho acero obtendrá alta resistencia a la tracción, dureza y" +
                " tenacidad después del " +
                "tratamiento térmico. Se utiliza ampliamente en los componentes de transmisión de maquinaria química pesada.",0));

        listaMateriales.add(new EquipoMateriales("Aceros de Herramientas","Es el acero que normalmente se emplea para la fabricación de útiles o herramientas destinados a" +
                " modificar la forma, " +
                "tamaño y dimensiones de los materiales por cortadura, presión o arranque de viruta.",R.drawable.aceros_herramientas));

        listaMateriales.add(new EquipoMateriales("Acero D-2 (De Temple al Aire)","Tiene un alto contenido de carbón y cromo y con muy alta resistencia al desgaste y mínimo cambio " +
                "dimensional después del tratamiento térmico. Por sus propiedades es ideal para la fabricación de dados de alta producción y en las herramientas para trabajo en frío de diseño muy intrincado.",0));

        listaMateriales.add(new EquipoMateriales("Acero D-3 (De Temple al Aceite)","Con alto contenido de carbón y cromo. Las piezas hechas con este acero llegan a tener muy alta" +
                " resistencia al desgaste u poco movimiento dimensional al tratamiento térmico. Es muy usado en herramientas para trabajos en frío.",0));

        listaMateriales.add(new EquipoMateriales("ACERO D-6","Se utiliza para formar herramientas; moldes para plásticos abrasivos y cerámicas; herramientas de prensa a largo " +
                "plazo; herramientas de corte y corte para materiales duros; herramientas de estampado; herramientas de raspado y etc.",0));

        listaMateriales.add(new EquipoMateriales("Acero A-2","Es de fácil maquinado en estado recocido y como los otros aceros herramienta de temple al aire, exhibe mínima" +
                " distorsión durante al temple, haciéndolo una excelente elección para herramientas de configuración complicada.",0));

        listaMateriales.add(new EquipoMateriales("Acero Herramienta Sidenor S-1","Tiene propiedades que le permiten ser utilizado también para trabajo en caliente. " +
                "Tiene elevada resistencia al impacto y a la fatiga, tanto en caliente como en frío. Presenta elevada tenacidad y buena resistencia a la abrasión.",0));

        listaMateriales.add(new EquipoMateriales("Acero SISA H-13","Provee un buen balance de tenacidad, alta resistencia a la formación de grietas causadas por el " +
                "choque térmico y resistencia al revenido, junto con resistencia al desgaste moderada. De temple al aire, es utilizado en la mayoría de las aplicaciones a durezas de 44-52 HRC.",0));

        listaMateriales.add(new EquipoMateriales("Acero O-1","Se utiliza como material de piezas duras. Las aplicaciones típicas para el acero para herramientas" +
                " O-1 son troqueles, moldes y molduras, calibradores, cortadores de corte, etc.",0));

        listaMateriales.add(new EquipoMateriales("Acero AISI O-2","Es un acero para herramientas de uso general de buena calidad que se usa a menudo cuando el" +
                " costo de un acero para herramientas con alto contenido de carbono y alto contenido de carbono no se justificaría. El acero AISI O2 tiene una dureza de trabajo de hasta 63-65HRC.",0));

        listaMateriales.add(new EquipoMateriales("Acero SISA P-20 pre-templado","Es de uso general para la fabricación de moldes. Utilizado para el maquinado y" +
                " electro-erosionado de moldes de plástico y componentes para la fundición de zinc. Se surte pre-templado a una dureza estándar de aprox. BHN 293-321 (HRC 30-34).",0));

        listaMateriales.add(new EquipoMateriales("Aceros Estructurales","Se produce básicamente para construcción de edificios (también llamado aceros de construcción )" +
                " y tiene una forma, composición química y resistencia concretas adaptadas a este propósito.",R.drawable.aceros_estructurales));

        listaMateriales.add(new EquipoMateriales("Acero 1010","Acero muy dúctil y maleable, de fácil conformación en frío y muy buena soldabilidad. Puede" +
                " ser ulizado como acero de cementación; permite estampación en frío. Bulones, ejes, cadenas, pasadores, bujes, tornillos, tuercas, acoples, racores, remaches; en estado calibrado " +
                "se usa para la fabricación de ejes.",0));

        listaMateriales.add(new EquipoMateriales("Acero al carbón 1018","Es el más común de los aceros rolados en frío. Es un producto muy útil debido a sus características " +
                "ípicas de buena resistencia mecánica y buena ductilidad. En terminos generales excelente soldabilidad y mejor maquinabilidad que la mayoría de los aceros al carbón.",0));

        listaMateriales.add(new EquipoMateriales("Acero 1020","Acero de bajo contenido de carbono permitiendo fácil mecanizado y gran soldabilidad, además puede ser cementado" +
                " obteniendo buena dureza en la superficie. Utilizado en la fabricación de maquinaria y construcción de piezas estructurales.",0));

        listaMateriales.add(new EquipoMateriales("Acero 1045","Acero grado ingeniería de aplicación universal que proporciona un nivel medio de resistencia mecánica y tenacidad " +
                "a bajo costo con respecto a los aceros de baja aleación. Frecuentemente se utiliza para elementos endurecidos a la llama ó por inducción.",0));

        listaMateriales.add(new EquipoMateriales("Aceros Inoxidables","Se define como una aleación de acero. También puede contener otros metales, como por " +
                "ejemplo molibdeno, níquel y wolframio.",R.drawable.aceros_inoxidables));

        listaMateriales.add(new EquipoMateriales("Acero 304","Se trata de proporciones elevadas que dan al acero inox 304 una gran resistencia a la corrosión. Además, " +
                "también contiene elementos de aleación importantes como el manganeso, silicio y carbono, igual que el inox 316. El resto de la composición química es básicamente hierro.",0));

        listaMateriales.add(new EquipoMateriales("Acero 310","Se usa comúnmente para aplicaciones de temperaturas elevadas. Su alto contenido de níquel y cromo" +
                " ofrecen excelente resistencia a temperaturas elevadas y a la oxidación en comparación con el Tipo 304 SS.",0));

        listaMateriales.add(new EquipoMateriales("Acero 316 - 316L","Es un acero inoxidable de cromo níquel austenítico que contiene molibdeno. Esta adición aumenta la" +
                " resistencia a la corrosión general, mejora la resistencia a picaduras de soluciones de iones de cloruro y proporciona mayor resistencia a temperaturas elevadas.",0));

        listaMateriales.add(new EquipoMateriales("Acero 410","Es un acero inoxidable martensítico que proporciona buena resistencia a la corrosión más alta " +
                "fortaleza y dureza. Es magnético en condiciones recocidas y endurecidas. Se puede desarrollar una amplia variedad de propiedades con diferentes tratamientos térmicos.",0));

        listaMateriales.add(new EquipoMateriales("Acero 416","Este acero es ferromagnético. Aplicaciones: Se usa en piezas que requieran ciertas " +
                "propiedades mecánicas y resistencia a la corrosión: Flechas de bombas de pozo profundo.",0));

        listaMateriales.add(new EquipoMateriales("Acero 420","Es una modificación del 410, con alto contenido de carbono, que le permite alcanzar " +
                "mayor dureza y mayor resistencia al desgaste aunque menor resistencia a la corrosión. Se utiliza para instrumentos dentales y quirúrgicos, hojas de cuchillos, moldes, herramientas, etc.",0));

        listaMateriales.add(new EquipoMateriales("Acero 430","El más utilizado de los aceros inoxidables ferríticos es el Tipo 430, que contiene 16 a 18% de " +
                "cromo y un máximo de 0,12% de carbono. Entre sus aplicaciones, se puede mencionar: cubiertos, vajillas, cocinas, piletas, monedas, revestimientos, mostradores frigoríficos.",0));

        listaMateriales.add(new EquipoMateriales("Laminas Antidesgaste","Es un acero de alto límite elástico y resistencia al desgaste, con una dureza y una tenacidad " +
                "favorables. Con este tipo de lámina podrá aumentar la vida útil de la maquinaria, disminuir el desgaste de los componentes estructurales y reducir costes.",R.drawable.laminas_antidesgaste));

        listaMateriales.add(new EquipoMateriales("XAR-plus","Permite corte térmico, conformado en frío y soldadura, entregando gran flexibilidad para la " +
                "fabricación de piezas de desgaste para aplicaciones en la industrias minera, de movimiento de tierras, cementera, de la madera y celulosa entre otras.",0));

        listaMateriales.add(new EquipoMateriales("Brinar 500Cr","Es indicado para todos los procedimientos de soldadura conocidos. El material debe " +
                "encontrarse como mínimo a temperatura ambiente. Recomendamos precalentar para espesores de chapa > 10 mm a 100 °C, para > 20 mm a 150 °C y para > 40 mm a 175 °C.",0));

        listaMateriales.add(new EquipoMateriales("Al Manganeso","Es una aleación de acero que contiene 12-14% de manganeso. Si bien el acero al manganeso garantiza el desgaste" +
                " y las propiedades de endurecimiento del trabajo, no es magnético, lo que lo hace ideal para su uso en conjuntos de transformadores eléctricos y para imanes de elevación industriales.",0));

        listaMateriales.add(new EquipoMateriales("Creusabro 4800","Combina una mayor formabilidad requerida para la fabricación de piezas complejas , y un mayor" +
                " desgaste y resistencia " +
                "a altas temperaturas, lo que resultó en un aumento en el servicio en un 30 – 50%.",0));

        listaMateriales.add(new EquipoMateriales("Creusabro 8000","Es un acero resistente a la abrasión con propiedades muy altas de resistencia a la tracción y " +
                "mayor resistencia a las fisuras para piezas estructurales sometidas a cargas pesadas en servicio.",0));

        listaMateriales.add(new EquipoMateriales("Aleaciones no Ferrosas","Son aquellas que no poseen en su composición el metal hierro. Por tanto, no consiste " +
                "en ninguno de los tipos de aceros, y su base principal puede ser la de cualquier otro elemento metálico; tales como aluminio, plata, cobre," +
                " berilio, magnesio, titanio, etc.",R.drawable.aleaciones_noferrosas));

        listaMateriales.add(new EquipoMateriales("SAE 660 (Bronce C932 o UNSC93200)","Es ideal para uso industrial en general ya que está diseñada para trabajos semipesados. " +
                "Compacto y uniforme, el bronce UNS C93200 cuenta con óptimas características antifricción y, a velocidades medias tiene gran resistencia al desgaste.",0));

        listaMateriales.add(new EquipoMateriales("Aleaciones Ferrosas","son las que tienen como elemento principal el hierro, combinado con otros elementos. " +
                "El principal de ellos es el carbono, cuya distribución y forma en el hierro o su reacción con éste formando carburos, le da varias de sus características.",R.drawable.aleaciones_ferrosas));

        listaMateriales.add(new EquipoMateriales("Hierro Gris","Es el hierro colado de uso más común. Sus escamas de grafito le dan" +
                "apariencia y nombre. La ASTM gradúa el hierro gris en siete clases, basadas en resistencia mínima a la" +
                "tensión en kpsi.",0));

        listaMateriales.add(new EquipoMateriales("Hierro Nodular","Es uno de los materiales ampliamente utilizados en la Industria" +
                "Automotriz, ya que presenta algunas ventajas con respecto al Acero o el Hierro" +
                "Gris, como son, por ejemplo, mayor resistencia a la fatiga y mayor resistencia al" +
                "desgaste, aunque con un costo mayor de fabricación, por su buena tenacidad",0));

    }

    /* Añadir mas a la lista si se ocupa
        listaMateriales.add(new EquipoMateriales("","",0));
     */
    public void mostrarLista(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterEquipoMateriales = new AdapterEquipoMateriales(getContext(), listaMateriales);
        recyclerView.setAdapter(adapterEquipoMateriales);
    }
    public void filtrar(String texto){
        ArrayList<EquipoMateriales> filtrarLista = new ArrayList<>();
        for (EquipoMateriales equipoMateriales : listaMateriales){
            if (equipoMateriales.getTituloEquipoMateriales().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoMateriales);
            }
            /* Para que el buscador considere tambien el contenido

            else if (equipoMateriales.getDescripcionMateriales().toLowerCase().contains(texto.toLowerCase())){
                filtrarLista.add(equipoMateriales);
            }*/
        }
        adapterEquipoMateriales.filtrar(filtrarLista);
    }
}