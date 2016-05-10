(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,user, auth){

        var loginCtrl = this;
        $scope.credentials = null;

        $scope.login = function(){

            user.login($scope.credentials.username, $scope.credentials.password)
                .then(handleRequest, handleRequest);

            if (auth.isAuthed()){
                $location.path('/main');
                $uibModalInstance.close('main');
            }
        };

        function handleRequest(res) {
            var token = res.data ? res.data.token : null;

            console.log(res);
            if(token) {
                console.log('JWT:', token);
            };
            self.message = res.data.message;
        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
