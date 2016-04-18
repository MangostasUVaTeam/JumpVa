(function (){

    var app = angular.module('signin', ['jumpva']);


    app.controller("SigninController", function($scope,$location,logedUser){

        var loginCtrl = this;

        this.cancel = function(){
            $location.path('/login');
        };

        this.createAccount = function(){
            $location.path('/main');
        };

    });
})();
