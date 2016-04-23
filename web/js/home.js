(function (){

    var app = angular.module('home', ['jumpva']);


    app.controller("HomeController", function($scope,$location){

        var loginCtrl = this;


        this.login = function(){
            console.log("Log");
            $location.path('/login');
        };

        this.signin = function(){
            $location.path('/signin');
        };

    });
})();
