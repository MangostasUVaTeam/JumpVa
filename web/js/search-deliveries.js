(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($scope, $uibModalInstance, logedUser  ) {
        $scope.logedUser = logedUser;

        $scope.cancel = function () {
          $uibModalInstance.dismiss('cancel');
        };
    });
})();
