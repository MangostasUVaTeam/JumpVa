(function (){

    var app = angular.module('jumpVa', [ ]);

    app.value('logedUser', {
        name: "Paco",
        carrier: true
    });


    app.controller("SearchController",['$scope','logedUser', function($scope,logedUser){
        this.search = function(text){
            console.log(logedUser);
            console.log(text);
        };
    }]);


    app.controller("NewDeliveryController",['$scope', 'logedUser', function($scope, logedUser){
        this.logedUser = logedUser;
    }]);



    app.controller("ToolController", ['$scope', 'logedUser', function($scope, logedUser){
        this.settings = logedUser;
    }]);
})();
