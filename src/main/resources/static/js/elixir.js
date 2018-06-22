angular.module('elixir', ['ngResource'])
    .config(['$resourceProvider', function($resourceProvider) {
        // Don't strip trailing slashes from calculated URLs
        $resourceProvider.defaults.stripTrailingSlashes = false;
    }])
    .controller('ElixirController',['$resource', function($resource) {
        var scope = this;
        scope.items = $resource('/api/v1/ingredients').query();
    }]);