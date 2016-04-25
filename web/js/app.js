(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate', 'ngMap','number-input',
    'main', 'toolbar','mainContent', 'home','login', 'signin','unassigned-delivery',
    'completed-delivery','search-deliveries', 'inprogress-delivery','millestone-delivery','user-info' ]);

    app.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.

                when('/home', {
                    templateUrl: 'includes/home.html',
                }).

                when('/main', {
                    templateUrl: 'includes/main.html',
                }).
                otherwise({
                    redirectTo: '/home'
                });
    }]);


    app.value('logedUser', {
        username: "Paco",
        carrier: true
    });

    app.value('deliveries', [
            {
                origen: "Valladolid",
                destino: "Paredes de nava",
                transportista: "",
                pendiente: true,
                puja: {
                    precio: 50,
                    date: Date.now()
                },
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete"
                },
                hitos:[
                        {
                            mensaje: "Creacion del envío",
                            tipo: "time",
                            time: Date.now()
                        }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "",
                pedido:{
                    descripcion: "tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[],
                pujas: [
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        valoracion: 3,
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        valoracion: 3,
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        valoracion: 3,
                        precio: 45
                    }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "",
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[],
                pujas: [
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Paco",
                        valoracion: 3,
                        precio: 50
                    },
                    {
                        transportista: "Juan",
                        valoracion: 3,
                        precio: 65
                    },
                    {
                        transportista: "Luis",
                        valoracion: 3,
                        precio: 32
                    },
                    {
                        transportista: "Miguel",
                        valoracion: 3,
                        precio: 45
                    }
                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 100,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Envío Completado",
                            tipo: "success",
                            time: "15:30",
                        }

                ]
            },
            {
                origen: "Valladolid",
                destino: "Palencia",
                transportista: "Paco",
                completado: 70,
                pedido:{
                    descripcion: "Tomates",
                    peso: 70,
                    altura: 130,
                    anchura: 20,
                    tipo: "Paquete",
                    imagen : "images/tomates.jpg"
                },
                hitos:[
                        {
                            mensaje: "Saliendo de Zaratan, Valladolid.",
                            tipo: "success",
                            time: "",
                            posicion: "pull-left"
                        },

                        {
                            mensaje: "De acuerdo, gracias.",
                            tipo: "",
                            time: "15:30",
                            posicion: "pull-right"
                        },

                        {
                          mensaje: "El envío llegara el Martes.",
                          tipo: "success",
                          time: "",
                          posicion: "pull-left"
                        }
                ]
            },
        ]
    );



})();
