import 'package:flutter/material.dart';
import 'package:puja_que_puja/screens/home/home.dart';

class Rutas {
  static final String home = '/Home';

  static final Map rutas = <String, WidgetBuilder>{
    Rutas.home: (BuildContext context) => new Home(),
  };
}
