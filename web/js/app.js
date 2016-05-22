(function (){

    var app = angular.module('jumpva', ['ngRoute','ui.bootstrap','ngAnimate',
    'ngMap','number-input','ui.bootstrap.datetimepicker', 'provider',
    'main', 'toolbar','mainContent', 'home','login', 'signin',
    'unassigned-delivery','completed-delivery','search-deliveries',
    'inprogress-delivery','millestone-delivery','user-info','create-delivery',
    'pending-to-assing-delivery'
    ]);

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
})();
