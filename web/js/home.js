(function (){

    var app = angular.module('home', ['jumpva']);


    app.controller("HomeController", function($scope,$location, $uibModal,$anchorScroll){

        var loginCtrl = this;


        this.login = function(){
            $uibModal.open({
                templateUrl: 'includes/login.html',
                controller: 'LoginController',
            });
        };

        this.signin = function(){
            $uibModal.open({
                controller: 'SigninController',
                templateUrl: 'includes/signin.html',
            });
        };

    });
})();
