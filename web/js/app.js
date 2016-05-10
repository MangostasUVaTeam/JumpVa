(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate',
    'ngMap','number-input', 'provider',
    'main', 'toolbar','mainContent', 'home','login', 'signin',
    'unassigned-delivery','completed-delivery','search-deliveries',
    'inprogress-delivery','millestone-delivery','user-info','create-delivery' ]);

    app.config(function($routeProvider,$httpProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: 'includes/home.html',
            }).when('/main', {
                templateUrl: 'includes/main.html',
            }).otherwise({
                redirectTo: '/home'
            });
        $httpProvider.interceptors.push('authInterceptor');
    });


    app.value('logedUser', {});

    app.value('deliveries', []);


    app.controller("MainController", function(user, auth){
        var self = this;

        /*
        function handleRequest(res) {
            var token = res.data ? res.data.token : null;

            if(token) {
                console.log('JWT:', token);
            };
            self.message = res.data.message;
        };

        self.login = function() {
            console.log("hola");

            user.login(self.username, self.password)
                .then(handleRequest, handleRequest);
            console.log("hola");

        };

        self.register = function() {
            user.register(self.username, self.password)
                .then(handleRequest, handleRequest);
        };

        self.getQuote = function() {
            user.getQuote()
                .then(handleRequest, handleRequest);
        };

        self.logout = function() {
            auth.logout && auth.logout();
        };

        self.isAuthed = function() {
            return auth.isAuthed ? auth.isAuthed() : false;
        };
        */
    });


})();
