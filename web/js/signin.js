(function (){

    var app = angular.module('signin', [ 'jumpva']);


    app.controller("SigninController",['$scope','$location','logedUser', function($scope,$location,logedUser){

        var loginCtrl = this;


        this.cancel = function(){
            console.log("Login");
            $location.path('/login');
        };

        this.createAccount = function(){
            $location.path('/main');
        };

    }]);
})();
