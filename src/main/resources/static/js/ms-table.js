Vue.component('ms-table', {
    data: function () {
        return {
            css: {
                table: {
                    tableClass: 'table table-striped table-bordered',
                    ascendingIcon: 'glyphicon glyphicon-chevron-up',
                    descendingIcon: 'glyphicon glyphicon-chevron-down',
                    handleIcon: 'glyphicon glyphicon-menu-hamburger'
                },
                pagination: {
                    wrapperClass: "pagination pull-right",
                    activeClass: "btn-primary",
                    disabledClass: "disabled",
                    pageClass: "btn btn-border",
                    linkClass: "btn btn-border",
                    icons: {
                        first: "",
                        prev: "",
                        next: "",
                        last: ""
                    }
                },
                paginationInfo: {
                    infoClass: "pagination pull-left",
                }
            }
        };
    },
    created:function(){
        if (this.config) {
            this.config.perPage ||  Vue.set(this.config, 'perPage', 10);
            this.config.queryParams ||  Vue.set(this.config, 'queryParams', {sort: 'sort', page: 'current', perPage: 'size'});
        }


    },
    methods: {
        onPaginationData(paginationData) {
            console.log(paginationData);
            console.log(this.$refs.pagination);

            this.$refs.paginationInfo.setPaginationData(paginationData);
            this.$refs.pagination.setPaginationData(paginationData);
        },
        onChangePage(page) {
            this.$refs.vuetable.changePage(page)
        },
        refresh: function () {
            this.$refs.vuetable.refresh();
        },
        selected: function () {
            console.log(this.$refs.vuetable);
            return this.$refs.vuetable.selectedTo;
        }
    },
    computed: {},
    props: ['config'],
    template: '<div>{{config}}' +
    '<vuetable ref="vuetable" :fields="config.fields" :api-url="config.apiUrl" :query-params="config.queryParams" @vuetable:pagination-data="onPaginationData" pagination-path="" :per-page="config.perPage" :append-params="config.moreParams" :css="css.table"></vuetable>' +
    '<vuetable-pagination-info ref="paginationInfo" :css="css.paginationInfo"></vuetable-pagination-info>' +
    '<vuetable-pagination ref="pagination" @vuetable-pagination:change-page="onChangePage" :css="css.pagination"></vuetable-pagination>' +
    '</div>'
});
//