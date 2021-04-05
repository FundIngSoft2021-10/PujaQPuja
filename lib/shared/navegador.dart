import 'package:flutter/material.dart';

class Navegador {
  eliminarPantallaActualYAbrir({@required BuildContext context, @required String nombreRuta}) {
    return Navigator.of(context).pushReplacementNamed(nombreRuta);
  }
}
