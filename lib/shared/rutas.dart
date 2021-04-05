import 'package:flutter/material.dart';
import 'package:puja_que_puja/screens/pantalla_inicial_temporal/home.dart';

class Rutas {
  static const String home = '/Home';

  static final Map rutas = <String, WidgetBuilder>{
    Rutas.home: (BuildContext context) => new PantallaTemporal(),
  };
}
