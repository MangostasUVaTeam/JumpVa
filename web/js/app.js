(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate',
    'ngMap','number-input',
    'main', 'toolbar','mainContent', 'home','login', 'signin',
    'unassigned-delivery','completed-delivery','search-deliveries',
    'inprogress-delivery','millestone-delivery','user-info','create-delivery' ]);

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

    app.value('deliveries', []);




})();
