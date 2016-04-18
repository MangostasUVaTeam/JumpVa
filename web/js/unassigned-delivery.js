(function (){

    var app = angular.module('unassigned-delivery', ['jumpva']);

    app.controller("UnassignedController", function($scope,$uibModal){
        this.assign = function(){
            $uibModal.open({
                templateUrl: 'includes/search-delivery.html'
            });
        };
    });

})();
