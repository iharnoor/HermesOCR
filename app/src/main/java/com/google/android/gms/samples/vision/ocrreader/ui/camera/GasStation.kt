package com.google.android.gms.samples.vision.ocrreader.ui.camera

data class GasStation(var stationName: String?,
                      var prices: HashMap<Double, Integer>,
                      var regPrice: Double,
                      var dieselPrice: Double,
                      var latitude: Double,
                      var longitude: Double)
